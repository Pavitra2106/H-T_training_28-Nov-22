import { Component, OnInit } from '@angular/core';
import Library from 'src/app/Entity/library';
import { LibraryService } from 'src/app/Service/library.service';

@Component({
  selector: 'app-get-delete',
  templateUrl: './get-delete.component.html',
  styleUrls: ['./get-delete.component.css']
})
export class GetDeleteComponent implements OnInit {
  constructor(private libraryService : LibraryService) { }
  librarys: Library[]=[];
  ngOnInit(): void {
    const promise = this.libraryService.getBooks();
    promise.subscribe((response) =>{
      console.log(response);
      this.librarys =response as Library[];
    })
  }
   deleteRow(library: any, index: number){
  const observables = this.libraryService.deleteBook(library);
  observables.subscribe(
    (response:any) => {
      console.log(response);   
    this.librarys.splice(index,1);
    alert(library.bookName+" Book Deleting");
    })
}

}
