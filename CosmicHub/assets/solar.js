var width = 768;
var height = 1200;
var c = document.getElementById("myCanvas");
var context = c.getContext("2d");
context.fillStyle="#000000";
context.fillRect(0, 0, width, height);

var stars = 500;
var day = 1000;
var startTime = new Date().getTime();

randomStars();

function randomStars()
{
    context.fillStyle="#000000";
    context.fillRect(0, 0, width, height);
    
    var x,y;
    for (var i = 0; i < stars; i++)
    {
        x = Math.floor((Math.random()*width + 1));
        y = Math.floor((Math.random()*height + 1));
        
        context.fillStyle = "#FFFFFF";
        context.fillRect(x, y, 1, 1);
    }
    
    if (view)
        view.drawBodies();
}

setInterval(randomStars, 1000);

function dayToSeconds(day, hour, min)
{
     return (day * 86400) + (hour * 3600) + (min * 60);
}

function scale(value, level)
{
    var result = value;
    for (var i = 0; i < level; i++)
    {
        result = result / 2;
    }
    
    return result;
}

function Body(day_length, distance, img, size, name)
{
    this.day_length = day_length;
    this.size = size;
    this.distance = scale(distance, 24);
    this.image = new Image();
    this.image.src = img;
}

var bodies;

function View()
{
    bodies = new Array();
    
    
    this.addBody = function(body)
    {
        bodies.push(body);
    };
    
    var sun_size = 100;
    var sun = new Image();
    sun.src = "planets/sun.png";
    
    this.drawBodies = function()
    {
        var origin_x = width / 2;
        var origin_y = height / 2;
        var body;
        context.fillStyle="#000000";
        context.fillRect(0, 0, width, height);
        
        var now = new Date();
        var time_elapsed = (now.getTime() - startTime);
        var degrees;
        
        context.drawImage(sun, origin_x - (sun_size / 2), origin_y - (sun_size / 2), sun_size, sun_size);
        
        for (var i = 0; i < bodies.length; i++)
        {
            body = bodies[i];
            
            context.beginPath();
            context.strokeStyle = "#808080";
            context.lineWidth = 1;
            context.arc(width / 2, height / 2, body.distance + sun_size, 0, 2*Math.PI);
            context.stroke();
            
            var degrees = (time_elapsed / body.day_length) * 360;
            var radians = (degrees * Math.PI) / 180;
            
            var x = Math.sin(radians) * (body.distance + sun_size);
            var y = Math.cos(radians) * (body.distance + sun_size);
            
            context.drawImage(body.image, origin_x + x - (body.size / 2), y + origin_y - (body.size / 2), body.size, body.size);
            
            }
    };
}

var mercury = new Body(dayToSeconds(58,15,30), 57910000, "planets/mercury.png", 10, "Mercury");
var venus = new Body(dayToSeconds(116,18,0), 108200000, "planets/venus.png", 10, "Venus");
var earth = new Body(dayToSeconds(1,0,0), 149600000, "planets/earth.png", 10, "Earth");
var mars = new Body(dayToSeconds(1,0,40), 227900000, "planets/mars.png", 10, "Mars");
var jupiter = new Body(dayToSeconds(0,9,56), 778500000, "planets/jupiter.png", 40, "Jupiter");
var saturn = new Body(dayToSeconds(1,10,39), 1433000000, "planets/saturn.png", 30, "Saturn");
var uranus = new Body(dayToSeconds(0,17,14), 2877000000, "planets/uranus.png", 25, "Uranus");
var neptune = new Body(dayToSeconds(0,16,6), 4503000000, "planets/neptune.png", 25, "Neptune");

var view = new View();
view.addBody(mercury);
view.addBody(venus);
view.addBody(earth);
view.addBody(mars);
view.addBody(jupiter);
view.addBody(saturn);
view.addBody(uranus);
view.addBody(neptune);

setInterval(view.drawBodies, 100);