import { useEffect, useRef } from "react";
import { useSelector } from "react-redux";
import "./style.css";

export default function Play() {
  const audioRef = useRef();
  const song = useSelector((state) => state.movie).selectedSong;

  useEffect(() => {
    console.log(audioRef);
    console.log(song);
    audioRef.current.load();
    audioRef.current.play();
    debugger;
  }, [song]);

  return (
    <div className="playArea">
      <audio ref={audioRef} controls>
        <source
          src={"http://localhost:9091/api/v1/movie/song?url=" + song.link}
          type="audio/mpeg"
        ></source>
      </audio>
      {/* <AudioPlayer
        elevation={1}
        width="100%"
        variation="default"
        spacing={3}
        download={true}
        autoplay={true}
        order="standart"
        preload="auto"
        loop={true}
        src={src}
      /> */}
    </div>
  );
}
