/*
Part 1
  Write a JavaScript program that modifies an image by putting three vertical stripes on it - a red stripe on the left one third, a green stripe in the middle, and a blue stripe on the right one third. 
*/
print("Excercise 1: ")
var img = new SimpleImage("hilton.jpg") ;
print(img);
var w = img.getWidth();
var x;
for(var pixel of img.values())
{
    x = pixel.getX();
     if (x < w/3) {
          pixel.setRed(255);
     }
     else if (x < 2*w/3) {
          pixel.setGreen(255);
     }
     else {
          pixel.setBlue(255);
     }
}

print(img);
print("\n\n");



/*
Part 2
Write a JavaScript function named swapRedGreen with one parameter pixel (representing a single pixel). This function should swap the red and green values of the pixel. For example, if you have a pixel with red = 255, green = 100, blue = 150, after calling swapRedGreen on that pixel its new RGB values would be red = 100, green = 255, blue = 150. 
*/
print("Excercise 2: ");
function swapRedGreen(pixel)
{
    var red = pixel.getRed();
    pixel.setRed(pixel.getGreen());
    pixel.setGreen(red);
    return pixel;
}
var img = new SimpleImage("usain.jpg") ;
print(img);
var w = img.getWidth();
for(var p of img.values())
{
    p = swapRedGreen(p);
}
print(img);
print("\n\n");



/*
Part 3
  Write code to change the Duke blue devil (the image below on the left) to be yellow (as in the image below on the right). 
*/
print("Excercise 3: ")
var img = new SimpleImage("duke_blue_devil.png") ;
print(img);
for(var p of img.values())
{
    if(p.getBlue() > p.getRed() || p.getBlue() > p.getGreen() )
    {
        p.setRed(255);
        p.setGreen(255);
        p.setBlue(0);
    }
}
print(img);
print("\n\n");










