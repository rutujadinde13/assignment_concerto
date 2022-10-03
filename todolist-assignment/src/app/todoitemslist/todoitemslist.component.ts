import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemList } from '../Listiteminterface/itemlist';
import { ItemListhttpService } from '../service/itemlisthttp.service';

@Component({
  selector: 'app-todoitemslist',
  templateUrl: './todoitemslist.component.html',
  styleUrls: ['./todoitemslist.component.css']
})
export class TodoitemslistComponent implements OnInit {


  itemForm: ItemList = {
    id: 0,
    itemname: ''
  };

  allitems:ItemList[]=[]
  constructor(private itemservice:ItemListhttpService,
    private router:Router) { }

  ngOnInit(): void {
    this.get();
  } 
  delete(id:number) {
    console.log("Delete id: "+id);
    this.itemservice.delete(id).subscribe({
      next: (data) => {
        this.allitems= this.allitems.filter(_ => _.id != id);        
      },
    });
  }
  get()
  {
    this.itemservice.get().subscribe((data) =>{
      this.allitems=data;
    }
    )
  }
  create(){
    
     this.itemservice.create(this.itemForm)     
     .subscribe({
      next:(data) => {           
        this.get();        
      },
      error:(err) => {
        console.log(err);
      }
    }) 
    this.itemForm.itemname='';
   }  
}
