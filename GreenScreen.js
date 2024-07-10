/*
Part 1 
Write the green screen algorithm you saw in the lecture video yourself. 
*/
print("Part 1 ");

var fgImage = new SimpleImage("drewRobert.png");

var bgImage = new SimpleImage("dinos.png");

var output = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());

for(var pixel of fgImage.values())
{
    if(pixel.getGreen() > pixel.getRed() + pixel.getBlue())
    {
        var p2 = bgImage.getPixel(pixel.getX(), pixel.getY());
        output.setPixel(pixel.getX(), pixel.getY(), p2);
    }
    else
    {
        output.setPixel(pixel.getX(), pixel.getY(), pixel);
    }
}
print(output);
print("\n\n");




/*
Part 2 
  Your friend is trying to write a program that draws a square 200 pixels by 200 pixels and that looks like this square with colors red (red value 255), green (green value 255), blue (blue value 255) and magenta (red value 255 and blue value 255). All other RGB values are set to 0.
  */
print("Part 2 ");

var img = new SimpleImage(200,200);
for (var px of img.values()){
  var x = px.getX();
  var y = px.getY();
  if (x < img.getWidth()/2){
    px.setRed(255);
  }
  if (y>img.getHeight()/2){
    px.setBlue(255);
  }
  if(x >= img.getWidth()/2 && y <= img.getHeight()/2) {
    px.setGreen(255);
  }
}
print (img);
print("\n\n");



/*
Part 3
Write a function named setBlack that has one parameter pixel (representing a single pixel) and returns pixel with its red, green, and blue components changed so that the pixel’s color is black.

Now you will write another function named addBorder. This function will add a black border to an image, such as in the following example:
*/
function setBlack(pixel)
{
    pixel.setRed(0);
    pixel.setGreen(0);
    pixel.setBlue(0);
}
function addBorder(img, border)
{
    var w = img.getWidth();
    var h = img.getHeight();
    for(var pixel of img.values())
    {
        if(pixel.getX() < border || pixel.getX() > w-border)
        {
            setBlack(pixel);
        }
        if(pixel.getY() < border || pixel.getY() > h-border)
        {
            setBlack(pixel);
        }
    }
}
var img = new SimpleImage("smallpanda.png");
addBorder(img, 10);
print(img);
print("\n\n");













