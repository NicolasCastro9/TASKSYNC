import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrl: './hello.component.css'
})
export class HelloComponent implements OnInit {

  message: string = "";

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getHello().subscribe(
      (response: string) => {
        this.message = response;
      },
      (error) => {
        console.error('Error al obtener el mensaje:', error);
      }
    );
  }


}
