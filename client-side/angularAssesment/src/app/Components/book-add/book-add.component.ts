import { Component, OnInit } from '@angular/core';
import Library from 'src/app/Entity/library';
import { LibraryService } from 'src/app/Service/library.service';

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent implements OnInit {

  bookName: String = '';
  bookAuthor: String = '';
  bookPrice ;
  bookGenre: String = '';
  borrowedStatus: Boolean ;

  library: Library = new Library();
  save() {
    if (this.library.bookName == "") {
      alert("Book Name is Null");
      return;
    }
    if (this.library.bookAuthor == "") {
      alert("Book Author is Null");
      return;
    }
    if (this.library.bookPrice == null) {
      alert("Book Price is Null");
      return;
    }
    if (this.library.bookGenre == "") {
      alert("Book Genre is Null");
      return;
    }
    if (this.library.borrowedStatus==null) {
      alert("Borrowed Status is Null");
      return;
    }
    const observables = this.libraryService.addBook(this.library);
    observables.subscribe(
      (response: any) => {
        console.log(response);
        alert("Book Added Successfully");
      }, function (error) {
        console.log(error);
        alert("something went wrong, Please try again!")
      })
  }
  constructor(private libraryService: LibraryService) { }

  ngOnInit(): void {
  }

}
