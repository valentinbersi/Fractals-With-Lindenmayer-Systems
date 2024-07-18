# Fractals with Lindenmayer systems

A Clojure program designed to draw fractals based on Lindenmayer Systems.

This was a task from the subject Programing Paradigms.
It consisted of implementing in Clojure a fractal drawer that worked with L-Systems.

## Usage

The program receives as arguments an input file (a .txt containing the L-System),
the iterations of the fractal (an integer)
and an output file (an .svg file where the fractal is going to be drawn).

The higher the number of iterations, the slower the program runs,
so if you don't want to be waiting for an hour don't go higher than five iterations.

The program is based on a Leiningen project, so to run it, just run the project with the desired arguments.

### Input File

The input file must have this format:

    ANGLE
    AXIOM
    RULES
    ...

#### Angle
A number that represents the angle that the fractal is going to turn when it's told to.

#### Axiom
The initial iteration of the fractal.

#### Rules
The rules have this format: Key Rule.
The key must be an ASCII simbol and the Rule a string.

## Working of the program

In the first iteration, the program will replace the given Axiom with its corresponding rule.
For example, imagine you have this L-System:

    22.5
    X
    F FF
    X F+[[X]-X]-F[-FX]+X

Here we have an angle of 22.5, out axiom is X, and our rules are F FF and X F+[[X]-X]-F[-FX]+X.
Then in the first iteration the program will replace the X with F+[[X]-X]-F[-FX]+X.
If a second iteration happens, for every character in the current string the program will search a rule for it and
replace it, if no rule is found then it does nothing.

## L-System

If you want to know what an L-System is, you can read it here: https://en.wikipedia.org/wiki/L-system

Here I'm going to explain the alphabet of the program:
* F or G: Advance one unit
* f or g: Advance one unit without drawing
* +: Rotate to the right the given angle
* -: Rotate to the left the given angle
* |: Turn around (rotate 180 degrees)
