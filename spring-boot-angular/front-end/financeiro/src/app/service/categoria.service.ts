import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Categoria } from '../model/categoria';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  public listar(): Observable<Array<Categoria>> {
    return this.http.get<Array<Categoria>>('http://localhost:8081/categorias');
  }

  public listarPorNome(nome: string): Observable<any> {

    if (nome) {
      const parametro = new HttpParams().set('nome', nome);
      return this.http.get('http://localhost:8081/categorias/filtrar', { params: parametro});
    }
  }

  public salvar(obj: Categoria): Observable<void> {


    if (!obj) {
      return throwError('Categoria inválida')
    }

    if (!obj.nome || obj.nome.trim().length <= 0) {
      return throwError('Nome da Categoria inválida')
    }
    return this.http.post<void>('http://localhost:8081/categorias', obj);
  }

  public remover(id: number): Observable<any> {
    if (!id || id <= 0) {
      return throwError('Categoria inválida')
    }
    return this.http.post('http://localhost:8081/categorias/remover', id);
  }
}
