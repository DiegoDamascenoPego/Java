import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Lancamento } from '../model/lancamento';

@Injectable({
  providedIn: 'root'
})
export class LancamentoService {

  constructor(private http: HttpClient) { }


  public listar():Observable<any>{
  return this.http.get('http://localhost:8081/lancamentos');
  }

  public salvar(obj: Lancamento):Observable<void>{
    if(!obj){
      return throwError('Lançamento inválido');
    }

    if(!obj.valor || obj.valor <= 0){
      return throwError('Valor inválido');
    }

    if(!obj.data){
      return throwError('Data inválida');
    }

    if(!obj.tipo){
      return throwError('tipo inválida');
    }

    return this.http.post<void>('http://localhost:8081/lancamentos', obj);
  }

  public remover(id: number):Observable<void>{

  if(!id || id <= 0){
    return throwError('Registro inválido');
  }
  return this.http.post<void>('http://localhost:8081/lancamentos/remover', id);

}


  
}


