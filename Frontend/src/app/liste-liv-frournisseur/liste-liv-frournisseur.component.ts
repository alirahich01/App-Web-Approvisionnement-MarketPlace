import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-liste-liv-frournisseur',
  templateUrl: './liste-liv-frournisseur.component.html',
  styleUrls: ['./liste-liv-frournisseur.component.css']
})
export class ListeLivFrournisseurComponent implements OnInit {
  livraisons:any;
  constructor(private fb: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  getlivraisons(): any{
    let id = this.route.snapshot.params['id'];
    this.http.get<any>('http://localhost:8098/'+id).subscribe(
      (res: any) => {
            this.livraisons = res;
      });

}}
