import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, EventEmitter } from '@angular/core';
import { MessageService } from 'primeng/api';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  static onConfirmar: EventEmitter<any> = new EventEmitter();

  constructor(private http: HttpClient, private mensagem: MessageService) { }

  static mostrarConfirmacao() {

  }


  onReject() {
    this.mensagem.clear('c');
    AppComponent.onConfirmar.emit(false);
  }

  onConfirm() {
    this.mensagem.clear('c');
    AppComponent.onConfirmar.emit(true);
  }

}
