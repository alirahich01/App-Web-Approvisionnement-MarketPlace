import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  form!: FormGroup;
  urlImageaddd: string | undefined;
  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }
  username: any;
  password: any;
 
  ngOnInit(): void { 
  }
  login(username:any,password:any){
    const data = {
      username: username,
      password: password,
    }
      this.http.post('http://localhost:8098/login', data, {observe:'response'}).subscribe(
      (res: any) => {
            console.log(res.headers.get('Authorization'));
            localStorage.setItem("token",res.headers.get('Authorization'))
            this.http.get<any>('http://localhost:8098/getRole',
            {headers: {'Authorization': `Bearer ${localStorage.getItem("token")}`}}
            ).subscribe(
                (resp: any) => {
                  console.log(resp[0].name)
                  localStorage.setItem("Role",resp[0].name);
              });
            Swal.fire({
              position: 'top-end',
              icon: 'success',
              title: 'you are connected',
              showConfirmButton: false,
              timer: 1500
            });
            this.username="";
            this.password="";
            window.location.href = "http://localhost:4200/articles";
      });
    

    }

    
}
