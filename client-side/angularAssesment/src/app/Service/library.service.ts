import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = 'http://localhost:6001/';
@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  addBook(library: {
    bookName: String;
    bookAuthor: String;
    bookPrice: number;
    bookGenre: String;
    borrowedStatus: Boolean;
  }) {
    return this.http.post(BASE_URL + "Add", library);
  }
  getBooks() {
    return this.http.get(BASE_URL + "getall");
  }
  deleteBook(library: any) {
    return this.http.delete(BASE_URL + "delete/" + library.bookId);
  }
  constructor(private http: HttpClient) { }
}
