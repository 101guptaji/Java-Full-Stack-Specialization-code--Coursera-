// Make a yellow square that is 200 pixels wide and 200 pixels high
//Yellow = rgb(255,255,0)
var img = new SimpleImage(200,200);
for(var p of img.values())
{
    p.setRed(255);
    p.setGreen(255);
    p.setBlue(0);
}
print(img);


