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
