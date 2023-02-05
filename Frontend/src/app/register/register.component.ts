import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form!: FormGroup;
  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router) { }
  ngOnInit(): void {
  }
  confirm_password:any;
  username:any;
  password:any;
  repssword:any;
  adr_cli:any;
  nom_cli:any;
  pre_cli:any;
  tel_cli:any;
  ville_cli:any;
  

  register(username:any,password:any,repssword:any,adr_cli:any,nom_cli:any,pre_cli:any,tel_cli:any,ville_cli:any){
    
    const data = {
      username: username,
      password: password,
      repssword: repssword,
      adr_cli: adr_cli,
      nom_cli: nom_cli,
      pre_cli: pre_cli,
      tel_cli: tel_cli,
      ville_cli: ville_cli,
    }
    console.log(data);
    this.http.post('http://localhost:8098/register', data).subscribe(
      (res: any) => {
        console.log(res);
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'register with Success',
          showConfirmButton: false,
          timer: 1500
        });
        window.location.href = "http://localhost:4200/login";
      }); 
  } 
}
