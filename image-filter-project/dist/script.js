//define global variable for image
var image = null;

//canvas for gray scale image
var canvas1 = document.getElementById("can1");

//upload the selected image to canvas
function doUpload() {
  var fileInput = document.getElementById("fInput");
  //SimpleImage object
  image = new SimpleImage(fileInput);
  clearCanvas();
  //draw the image on the canvas
  image.drawTo(canvas1);
}

//make gray scale image on canvas
function makeGray() {
  if (imageIsLoaded(image)) {
    var grayImage = new SimpleImage(image);
    if (imageIsLoaded(grayImage)) {
      var avg = 0;
      for (var pixel of grayImage.values()) {
        var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
        avg = sum / 3;
        pixel.setRed(avg);
        pixel.setGreen(avg);
        pixel.setBlue(avg);
      }
      grayImage.drawTo(canvas1);
    }
  }
}

//make rainbow filter
function makeRainbow() {
  if (imageIsLoaded(image)) {
    var rainImage = new SimpleImage(image);
    if (imageIsLoaded(rainImage)) {
      var h = rainImage.getHeight();
      for (var pixel of rainImage.values()) {
        y = pixel.getY();
        //Red
        if (y < h / 7) {
          var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
          var avg = sum / 3;
          if (avg < 128) {
            pixel.setRed(2 * avg);
            pixel.setGreen(0);
            pixel.setBlue(0);
          } else {
            pixel.setRed(255);
            pixel.setGreen(2 * avg - 255);
            pixel.setBlue(2 * avg - 255);
          }
        }
        //Orange
        else if (y < (2 * h) / 7) {
          var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
          var avg = sum / 3;
          if (avg < 128) {
            pixel.setRed(2 * avg);
            pixel.setGreen(0.8 * avg);
            pixel.setBlue(0);
          } else {
            pixel.setRed(255);
            pixel.setGreen(1.2 * avg - 51);
            pixel.setBlue(2 * avg - 255);
          }
        }
        //Yellow
        else if (y < (3 * h) / 7) {
          var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
          var avg = sum / 3;
          if (avg < 128) {
            pixel.setRed(2 * avg);
            pixel.setGreen(2 * avg);
            pixel.setBlue(0);
          } else {
            pixel.setRed(255);
            pixel.setGreen(255);
            pixel.setBlue(2 * avg - 255);
          }
        }
        //Green
        else if (y < (4 * h) / 7) {
          var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
          var avg = sum / 3;
          if (avg < 128) {
            pixel.setRed(0);
            pixel.setGreen(2 * avg);
            pixel.setBlue(0);
          } else {
            pixel.setRed(2 * avg - 255);
            pixel.setGreen(255);
            pixel.setBlue(2 * avg - 255);
          }
        }
        //Blue
        else if (y < (5 * h) / 7) {
          var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
          var avg = sum / 3;
          if (avg < 128) {
            pixel.setRed(0);
            pixel.setGreen(0);
            pixel.setBlue(2 * avg);
          } else {
            pixel.setRed(2 * avg - 255);
            pixel.setGreen(2 * avg - 255);
            pixel.setBlue(255);
          }
        }
        //Indigo
        else if (y < (6 * h) / 7) {
          var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
          var avg = sum / 3;
          if (avg < 128) {
            pixel.setRed(0.8 * avg);
            pixel.setGreen(0);
            pixel.setBlue(2 * avg);
          } else {
            pixel.setRed(1.2 * avg - 51);
            pixel.setGreen(2 * avg - 255);
            pixel.setBlue(255);
          }
        }
        //Violet
        else {
          var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
          var avg = sum / 3;
          if (avg < 128) {
            pixel.setRed(1.6 * avg);
            pixel.setGreen(0);
            pixel.setBlue(1.6 * avg);
          } else {
            pixel.setRed(0.4 * avg + 153);
            pixel.setGreen(2 * avg - 255);
            pixel.setBlue(0.4 * avg + 153);
          }
        }
      }
      rainImage.drawTo(canvas1);
    }
  }
}

//red filter
function makeRed() {
  if (imageIsLoaded(image)) {
    var rhImage = new SimpleImage(image);
    if (imageIsLoaded(rhImage)) {
      var avg = 0;
      for (var pixel of rhImage.values()) {
        var sum = pixel.getRed() + pixel.getGreen() + pixel.getBlue();
        avg = sum / 3;
        if (avg < 128) {
          pixel.setRed(2 * avg);
          pixel.setGreen(0);
          pixel.setBlue(0);
        } else {
          pixel.setRed(255);
          pixel.setGreen(2 * avg - 255);
          pixel.setBlue(2 * avg - 255);
        }
      }
      rhImage.drawTo(canvas1);
    }
  }
}

function makeBlur() {
  if (imageIsLoaded(image)) {
    var w = image.getWidth();
    var h = image.getHeight();
    var newImage = new SimpleImage(w, h);
    if (imageIsLoaded(newImage)) {
      for (var pixel of image.values()) {
        var x = pixel.getX();
        var y = pixel.getY();
        var num = Math.random();
        if (num < 0.5) {
          newImage.setPixel(x, y, pixel);
        } else {
          var randomX = Math.random() * 11;
          var randomY = Math.random() * 11;
          if (randomX >= 0 && randomX + x <= w) {
            if (randomY >= 0 && randomY + y <= h) {
              var newPixel = image.getPixel(randomX + x, randomY + y);
              newImage.setPixel(x, y, newPixel);
            } else {
              if (Math.abs(y - randomY) >= 0 || Math.abs(randomY - y) <= h) {
                var newPixel = image.getPixel(
                  randomX + x,
                  Math.abs(y - randomY)
                );
                newImage.setPixel(x, y, newPixel);
              } else {
                var newPixel = image.getPixel(randomX + x, y);
                newImage.setPixel(x, y, newPixel);
              }
            }
          } else {
            if (Math.abs(x - randomX) >= 0 || Math.abs(randomX - x) <= w) {
              var newPixel = image.getPixel(Math.abs(randomX - x), y);
              newImage.setPixel(x, y, newPixel);
            } else {
              var newPixel = image.getPixel(x, y);
              newImage.setPixel(x, y, newPixel);
            }
          }
        }
      }
    }
    newImage.drawTo(canvas1);
  }
}

//make window image
function makeWindow() {
  if (imageIsLoaded(image)) {
    var brImage = new SimpleImage(image);
    if (imageIsLoaded(brImage)) {
      var side = 20;
      var w = brImage.getWidth();
      var h = brImage.getHeight();
      for (var pixel of brImage.values()) {
        var x = pixel.getX();
        var y = pixel.getY();
        if (
          x < side ||
          x > w - side ||
          (x > w / 3 && x < w / 3 + side) ||
          (x > (2 * w) / 3 && x < (2 * w) / 3 + side)
        ) {
          pixel.setRed(255);
          pixel.setGreen(165);
          pixel.setBlue(0);
        }
        if (
          y < side ||
          y > h - side ||
          (y > h / 3 && y < h / 3 + side) ||
          (y > (2 * h) / 3 && y < (2 * h) / 3 + side)
        ) {
          pixel.setRed(255);
          pixel.setGreen(165);
          pixel.setBlue(0);
        }
      }
      brImage.drawTo(canvas1);
    }
  }
}

//reset the filters
function reset() {
  clearCanvas();
  if (imageIsLoaded(image)) {
    image.drawTo(canvas1);
  }
}

//to check if image is loaded
function imageIsLoaded(img) {
  if (img == null || !img.complete()) {
    alert("image not loaded");
    return false;
  }
  return true;
}

//clear the canvas
function clearCanvas() {
  //clear gray scale image canvas on uploading a new image
  var context = canvas1.getContext("2d");
  context.clearRect(0, 0, canvas1.width, canvas1.height);
}