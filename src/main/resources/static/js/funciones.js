const main_video = document.querySelector('.main-video video');
const main_video_title = document.querySelector('.main-video .title');
const video_playlist = document.querySelector('.video-playlist .videos');

let data = [
    {
        'id': 'a1',
        'title': 'video_1',
        'name': 'video1.mp4',
        'duration': '4:07',
    },
    {
        'id': 'a2',
        'title': 'video_2',
        
    },
    {
        'id': 'a3',
        'title': 'video_3',
        'name': '3D popup card.mp4',
        'duration': '0:28',
    },

    {
        'id': 'a4',
        'title': 'video_4',
        
    },
    {
        'id': 'a5',
        'title': 'video_5',
        
    },
    {
        'id': 'a6',
        'title': 'video_6',
       
    },
    {
        'id': 'a7',
        'title': 'video_7',
        
    },

    {
        'id': 'a8',
        'title': 'video_8',
      
    },
    {
        'id': 'a9',
        'title': 'video_9',
        
    },

];

data.forEach((video, i) => {
    let video_element = `
                <div class="video" data-id="${video.id}">
                    <img src="images/play.svg" alt="">
                    <p>${i + 1 > 9 ? i + 1 : '0' + (i + 1)}. </p>
                    <h3 class="title">${video.title}</h3>
                    <p class="time">${video.duration}</p>
                </div>
    `;
    video_playlist.innerHTML += video_element;
})

let videos = document.querySelectorAll('.video');
videos[0].classList.add('active');
videos[0].querySelector('img').src = 'images/pause.svg';

videos.forEach(selected_video => {
    selected_video.onclick = () => {

        for (all_videos of videos) {
            all_videos.classList.remove('active');
            all_videos.querySelector('img').src = 'images/play.svg';

        }

        selected_video.classList.add('active');
        selected_video.querySelector('img').src = 'images/pause.svg';

        let match_video = data.find(video => video.id == selected_video.dataset.id);
        main_video.src = 'videos/' + match_video.name;
        main_video_title.innerHTML = match_video.title;
    }
});