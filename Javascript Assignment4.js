/*
Exercise 1 - Turn the chapel red.
Write code that starts with the image “chapel.png” shown below on the left and turns the red part of every pixel to the highest red value possible
*/
print("Excercise 1: ");
var img = new SimpleImage("chapel.png");
print(img);
for(var pixel of img.values())
{
    if(pixel.getRed() > 0)
          pixel.setRed(255);
      }
}
print(img);
print("\n\n");

/*
Exercise 2 - Remove all the red
Write code that starts with the image “chapel.png” shown below on the left and removes all the red, resulting in the image shown on the right. You will notice that in the resulting image you will mostly see blue and green colors.
*/
print("Excercise 2: ");
var img = new SimpleImage("chapel.png");
print(img);
for(var p of img.values())
{
    p.setRed(0);
}
print(img);
print("\n\n");


/*
Exercise 3 - Turn the eggs less red
Write code that starts with the image “eastereggs.jpg” shown below on the left and reduces all the red pixel values that are greater than 70 to 70, resulting in the image shown on the right.
*/
print("Excercise 3: ");
var img = new SimpleImage("eastereggs.jpg");
print(img);
for(var p of img.values())
{
    if(p.getRed()>70)
    {
        p.setRed(70);
    }
}
print(img);
print("\n\n");



/*
Exercise 4 - Add Thick Black Line to Bottom of Owen
Write code that starts with the image “astrachan.jpg” shown below on the left and replaces the bottom ten rows with black pixels, resulting in the image shown on the right. Note that the color black has a red value of 0, a green value of 0 and a blue value of 0. Also note that the pixel in the top left corner has x-value 0 and y-value 0.
*/
print("Excercise 4: ");
var img = new SimpleImage("astrachan.jpg");
print(img);
for(var p of img.values())
{
    if(p.getY()>(img.getHeight()-10))
    {
        p.setRed(0);
        p.setGreen(0);
        p.setBlue(0);
    }
}
print(img);
print("\n\n");



/*
Exercise 5 - Green square in top left corner
Write code that starts with the image “chapel.png” shown below on the left, and replaces the top left corner with an all green square of size 50 by 50, resulting in the image on the right below.
*/
print("Excercise 5: ");
var img = new SimpleImage("chapel.png");
print(img);
for(var p of img.values())
{
    if(p.getX() < 50 && p.getY() < 50)
    {
        p.setRed(0);
        p.setGreen(255);
        p.setBlue(0);
    }
}
print(img);
print("\n\n");




/*
Exercise 6 - Rectangle of any color in top right corner
Write a function named topRightCorner that puts a rectangle of a specified color and size in the top right corner of the image. The function topRightCorner has six parameters named cornerWidth, cornerHeight, someImage, red, green, and blue. This function replaces the top right corner of the image someImage with a rectangle of height cornerHeight and width cornerWidth, and color that has red, green and blue numeric values.
*/
print("Excercise 6: ")
function topRightCorner(cW, cH, img, red, green, blue)
{
    for(var p of img.values())
    {
        if(p.getX() > (img.getWidth()-cW) && p.getY() < cH)
        {
            p.setRed(red);
            p.setGreen(green);
            p.setBlue(blue);
        }
    }
    return img;
}
/*var picture = new SimpleImage("chapel.png");
var result = topRightCorner(30, 60, picture, 255, 255, 0);
print(result);
var picture2 = new SimpleImage("smalllion.jpg");
var result2 = topRightCorner(125, 20, picture2, 255, 0, 0);
print(result2); */
var picture = new SimpleImage("chapel.png");
var result = topRightCorner(30, 60, picture, 255, 255, 0);
var result2 = topRightCorner(60, 30, result, 0, 0, 255);
var result3 = topRightCorner(30, 30, result2, 0, 255, 0);
print(result3);
print("\n\n")



/*
Exercise 7 - Changes in Red
Write the function named changeRed that draws a rectangle of width 256 showing all the changes of the color red, from left to right repeatedly, while blue and green are both set to 0.
*/
print("Excercise 7: ");
function changeRed(width, height) {
    var img = new SimpleImage(width, height);
    //print(img.getWidth());
    var red = 0;
    for(var pixel of img.values())
    {
        pixel.setRed(red);
        pixel.setGreen(0);
        pixel.setBlue(0);
        if (pixel.getRed() < 255) {
            red = red + 1;
        }
        if (pixel.getRed() == 255) {
            red = 0;
        }
    }
    //print(red);
    return img;
}

var result = changeRed(256,200);
print(result);













