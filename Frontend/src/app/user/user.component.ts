import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  clients:any;

  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  getClients(): any{
    let id = this.route.snapshot.params['id'];
    this.http.get<any>('http://localhost:8098/'+id).subscribe(
      (res: any) => {
            this.clients = res;
      });

}

}
