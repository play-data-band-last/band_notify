import React, { useState } from 'react';

const ImageList = ({ jsonString }) => {
  const imageUrlArray = JSON.parse(jsonString);
  const [currentImageIndex, setCurrentImageIndex] = useState(0);

  const nextImage = () => {
    setCurrentImageIndex((prevIndex) => (prevIndex + 1) % imageUrlArray.length);
  };

  const prevImage = () => {
    setCurrentImageIndex((prevIndex) => (prevIndex - 1 + imageUrlArray.length) % imageUrlArray.length);
  };

  return (
    <div className="image-list-container">
      <div className="image-slider">
        <button onClick={prevImage}>&lt;</button>
        <div className="image-slider-frame">
          <img
            src={imageUrlArray[currentImageIndex]}
            alt={`Image ${currentImageIndex}`}
            className="image-list-img"
          />
        </div>
        <button onClick={nextImage}>&gt;</button>
      </div>
    </div>
  );
};

export default ImageList;
