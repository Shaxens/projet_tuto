
export class Projet {
  id: number;
  name: string;
  description: string;
  picture: string;
  status: boolean;

  constructor(
    id: number = 22,
    name: string = 'nooommmmm',
    description: string = 'descriptionn',
    picture: string = 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.journaldugeek.com%2F2014%2F03%2F31%2Fsabotage-arnold-schwarzenegger-les-jeux-video-sont-beaucoup-plus-violents-que-mon-nouveau-film%2F&psig=AOvVaw3fQRejcLQyy9JluNCmviBZ&ust=1653844580594000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCPDoiKjZgvgCFQAAAAAdAAAAABAD',
    status: boolean = true
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.picture = picture;
    this.status = status;
  }

}

export class ProjetId {
  id: number;
  url: string;


  constructor(id: number, url: string) {
    this.id = id;
    this.url = url;
  }
}
