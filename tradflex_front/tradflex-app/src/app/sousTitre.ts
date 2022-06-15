import { Projet } from "./projet";

export class SousTitre {
    id: number;
    body: string;
    timeCodeBegin: number;
    timeCodeEnd: number;
    idProject: number;
    constructor(
        id: number,
        body: string,
        timeCodeBegin: number,
        timeCodeEnd: number,
        idProject: number
    ) {
        this.id = id;
        this.body = body;
        this.timeCodeBegin = timeCodeBegin;
        this.timeCodeEnd = timeCodeEnd;
        this.idProject = idProject;
    }
    
    }
    