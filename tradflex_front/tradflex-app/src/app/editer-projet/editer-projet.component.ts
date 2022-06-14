import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import WaveSurfer from 'wavesurfer.js';
import TimelinePlugin from 'wavesurfer.js/src/plugin/timeline';
import { ProjetService } from '../DirectoryFilm/projet.service';
import { Projet } from '../projet';

@Component({
  selector: 'app-editer-projet',
  templateUrl: './editer-projet.component.html',
  styleUrls: ['./editer-projet.component.css']
})

export class EditerProjetComponent implements OnInit {
  projet: Projet|undefined;

  timeTotal!: HTMLElement;
  currentTime!: HTMLElement;
  timeRemaining!: HTMLElement;
  
  video!: WaveSurfer;

  // url = "../assets/video/PETIT_BISCUIT-Sunset_Lover.mp4";
  url = "../assets/video/Avatar_2.mp4";
  // url = "../assets/video/Parodie_300.mp4";
  // url = "../assets/video/Corneil_et_bernie.mp4";
  // url = "https://ia800508.us.archive.org/15/items/LoveThemeFromTheGodfather/02LoveThemeFromTheGodfather.mp3";

  constructor( private cdr: ChangeDetectorRef, private route: ActivatedRoute,
                private projetService : ProjetService) { }

// A l'initialisation on compare l'id du projet avec l'api pour récupérer le json
  ngOnInit(): void {
    const projetId: string|null = this.route.snapshot.paramMap.get('id');
    console.log(projetId);
    if(projetId){
      this.projetService.getProjetById(+projetId)
      .subscribe(projet => this.projet = projet);
      console.log(this.projet);
    } else {
      this.projet = undefined;
    }
    //Si la vidéo n'existe pas alors on la génère
    if (!this.video) {
      this.generateVideo();
    }
    this.cdr.detectChanges();

    Promise.resolve().then(() => this.video.load(this.url));
}


/**
 * @params: container: on définit le container de la vidéo et de la waveform
 * @params: backend: on choisit ce qu'on veut retourner, ici une vidéo donc MediaElement pour les gros fichiers
 * @params: mediaType: Le type que l'on veut retourner donc vidéo
 * @params: mediaControls: Si on a besoin de controls sur la vidéo alors true
 * @params: waveColor: La couleur de la waveform
 * @params: progressColor: La couleur de la progression de la waveform
 * @params: cursorColor: La couleur du curseur (a l'endroit actuel de la waveform)
 * @params: responsive: Si on veut du responsive alors true
 */


  generateVideo(): void {
    // On créer la vidéo et on lui attributs divers paramètres
    Promise.resolve(null).then(() => {
      this.video = WaveSurfer.create({
        container: '#waveform',
        backend: 'MediaElement',
        mediaType: 'video',
        mediaControls: true,
        waveColor: 'orange',
        progressColor: 'purple',
        cursorColor: 'red',
        responsive: true,
      });
    // Quand la vidéo est prête on déplace les éléments vidéo et waveform
      this.video.on('ready', () => {

        let parentWaveForm = document.getElementsByTagName('wave')[0].parentNode as HTMLElement;
        let videoWidth = document.getElementsByTagName('video')[0] as HTMLElement;
        let waveformPosition = document.getElementsByTagName('wave')[0] as HTMLElement;

        parentWaveForm.insertBefore(videoWidth, waveformPosition);
        videoWidth.style.maxWidth = '50%';

        // On calcule les différentes durées de la vidéo puis on la lance
        this.calcul();

    })
  }
    )}
    // Fonction qui permet de calculer les différents temps nécessaires
  calcul(): void {
    this.video.on('audioprocess', () => {
      if (this.video.isPlaying()) {
        let totalTime = this.video.getDuration(),
        currentTime = this.video.getCurrentTime(),
        timeRemaining = totalTime - currentTime;

        this.timeTotal = document.getElementById('time-total') as HTMLElement;
        this.timeTotal.innerText = totalTime.toFixed(1);

        this.currentTime = document.getElementById('time-current') as HTMLElement;
        this.currentTime.innerText = currentTime.toFixed(1);

        this.timeRemaining = document.getElementById('time-remaining') as HTMLElement;
        this.timeRemaining.innerText = timeRemaining.toFixed(1);
      }
      

    })
  }

  onPreviewPressed(): void {
    this.video.play();
  }

  onStopPressed(): void {
    this.video.stop();
  }
  
}

