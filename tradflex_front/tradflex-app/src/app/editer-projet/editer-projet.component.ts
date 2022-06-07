import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import WaveSurfer from 'wavesurfer.js';
import MediaElement from 'wavesurfer.js/src/mediaelement';
import TimelinePlugin from 'wavesurfer.js/src/plugin/timeline';

@Component({
  selector: 'app-editer-projet',
  templateUrl: './editer-projet.component.html',
  styleUrls: ['./editer-projet.component.css']
})
export class EditerProjetComponent implements OnInit {

  video!: WaveSurfer;
  // url = "../assets/video/PETIT_BISCUIT-Sunset_Lover.mp4";
  // url = "../assets/video/Parodie_300.mp4";
  url = "../assets/video/Corneil_et_bernie.mp4";
  // url = "https://ia800508.us.archive.org/15/items/LoveThemeFromTheGodfather/02LoveThemeFromTheGodfather.mp3";

  constructor( private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
  }

  generateVideo(): void {
    Promise.resolve(null).then(() => {
      this.video = WaveSurfer.create({
        container: '#waveform',
        backend: 'MediaElement',
        mediaType: 'video',
        waveColor: 'orange',
        progressColor: 'purple',
        cursorColor: 'red',
        responsive: true,
        plugins: [
          TimelinePlugin.create({
            container: '#wave-timeline'
          })
        ]
      });
      this.video.on('ready', () => {
        this.video.play();
      })
    })
  }

  onPreviewPressed(): void {
    if (!this.video) {
      this.generateVideo();
    }

    this.cdr.detectChanges();

    Promise.resolve().then(() => this.video.load(this.url));
  }

  onStopPressed(): void {
    this.video.stop();
  }
}
