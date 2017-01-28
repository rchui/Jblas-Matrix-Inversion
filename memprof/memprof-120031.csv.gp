#gplot file
set term png size 1024,680 enhanced 
set output "memprof-120031.csv.png"
set multiplot layout 3,1 title "memprof-120031.csv : java" 
set tmargin 0
unset xtics
set xrange [0:140]
set lmarg 13
set rmarg 10
set key center right nobox
set ytics
set y2tics
set ylabel "Memory usage (kB)"
plot 'memprof-120031.csv.dat' using 1:4 with lp title "VmSize (kB)", 'memprof-120031.csv.dat' using 1:5 with lp title "VmRSS (kB)"
set key center right nobox
set ytics
set y2tics
set ylabel "I/O (bytes/sec)"
plot 'memprof-120031.csv.dat' using 1:6 with lp title "rchar(bytes/sec)", 'memprof-120031.csv.dat' using 1:7 with lp title "wchar(bytes/sec)"
set key center right nobox
set ytics nomirror
set y2tics
set yrange [0:100]
set ylabel "# of threads"
set autoscale y2
set y2label "CPU load (%)"
set xtics out nomirror rotate
set xlabel "time (s)"
plot 'memprof-120031.csv.dat' using 1:2 with lp title "# threads" axes x1y1, 'memprof-120031.csv.dat' using 1:3 with lp title "% CPU" axes x1y2
unset multiplot
