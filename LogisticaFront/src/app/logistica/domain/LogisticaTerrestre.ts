import { Bodega } from "src/app/bodega/domain/Bodega";
import { Camion } from "src/app/camion/domain/Camion";

export class LogisticaTerrestre{
  logisticaTerrestreId?:number;
  camion?:Camion;
  bodega?:Bodega;
}
