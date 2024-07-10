// write your code here
//Assignment 1
//Question 1
var x = 3;
var y = 4;
var z = x + 2*y;
print(x);
print(y);
print(z);

//Question 2
var x = 3;
var y = 2;
y = x;
print (x);
print (y);

//Question 3
//	creates an object of SimpleImage to represent the image
var img = new SimpleImage("chapel.png");
print(img);
var w = img.getWidth();
print("Width: ",w);
var h = img.getHeight();
print("Height: ",h);

var p = img.getPixel(0,0);
print("Pixel: ",p);
var red = p.getRed();
print("Red: ",red);
var green = p.getGreen();
print("Green: ",green);
var blue = p.getBlue();
print("Blue: ",blue);

print("X =", p.getX());
print("Y =",p.getY());

var alpha = p.getAlpha();
print("Transparency: ",alpha);

p.setRed(255);
p.setGreen(255);
p.setBlue(255);
print("New Pixel:", p);

//Question 4
function square(x){
	var ans = x*x;
	return ans;
}
print("Square of 4 = ", square(4));

function cube(x)
{
    return x*x*x;
}
print("Cube of 4 = ",cube(4));

//Question 5
function add(x,y)
{
    return x+y;
}
print("'1'+ '1' = ",add('1','1') );
print("1+ 1 = ",add(1,1) );




