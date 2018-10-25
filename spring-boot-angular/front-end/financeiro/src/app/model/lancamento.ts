import { Categoria } from "./categoria";

export class Lancamento {
    id: number;
    nome: string;
    tipo: TipoLancamento;
    valor: number;
    data: Date;
    categoria: Categoria;
}

export enum TipoLancamento { RECEITA, DESPESA }