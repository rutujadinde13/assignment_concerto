import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ItemList } from '../Listiteminterface/itemlist';

@Injectable({
  providedIn: 'root'
})
export class ItemListhttpService {
  
url:string = "http://localhost:3000/listoftodoitems";

constructor(private http:HttpClient) { }

get()
{
  return this.http.get<ItemList[]>(this.url);
}
create(payload: ItemList) {
  return this.http.post<ItemList>(this.url, payload);
}  
delete(id:number){    
  return this.http.delete<ItemList>(this.url+'/'+id);   
} 
}
