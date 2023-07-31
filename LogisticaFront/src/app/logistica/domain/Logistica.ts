import { Cliente } from "src/app/clientes/domain/Cliente";
import { TipoProducto } from "src/app/tipoproducto/domain/TipoProducto";
import { LogisticaMaritima } from "./LogisticaMaritima";
import { LogisticaTerrestre } from "./LogisticaTerrestre";

export class Logistica{
  logisticaId?:number;
  tipoProducto?: TipoProducto = new TipoProducto();
  precioEnvio?: number;
  cantidadProducto?:number;
  subTotal?:number;
  porcentajeDescuento?:number;
  total?:number;
  fechaRegistro?:Date;
  fechaEntrega?:Date;
  cliente?: Cliente = new Cliente();
  logisticaMaritima?:LogisticaMaritima;
  logisticaTerrestre?:LogisticaTerrestre;
}
