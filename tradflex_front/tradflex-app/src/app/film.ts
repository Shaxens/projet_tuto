
export class Film {
  id: number;
  name: string;
  description: string;
  picture: string;
  status: boolean;
  constructor(
    id: number = 22,
    name: string = 'nooommmmm',
    description: string = 'descriptionn',
    picture: string = 'adresseImage',
    status: boolean = true
  ) {
    this.id = id;
    this.name = name;
    this.description = description; 
    this.picture = picture;
    this.status = status;
  }

}
