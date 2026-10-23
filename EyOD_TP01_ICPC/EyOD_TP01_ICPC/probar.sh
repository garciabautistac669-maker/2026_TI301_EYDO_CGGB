#!/bin/bash
# Compila TODAS las versiones (optimizada y fuerza bruta) de cada problema,
# ejecuta todos sus casos y compara contra salidaN.txt
cd "$(dirname "$0")"
ok=0; fail=0
for d in */; do
  d=${d%/}
  for f in "$d"/*.java; do
    cls=$(basename "$f" .java)
    mkdir -p /tmp/out_$cls
    javac -d /tmp/out_$cls "$f" || { echo "ERROR compilando $cls"; fail=$((fail+1)); continue; }
    for c in "$d"/caso*.txt; do
      n=${c##*caso}; n=${n%.txt}
      r=$(java -cp /tmp/out_$cls $cls < "$c")
      e=$(cat "$d/salida$n.txt")
      if [ "$r" == "$e" ]; then ok=$((ok+1)); else fail=$((fail+1)); echo "FALLA $cls caso$n: obtuvo [$r] esperado [$e]"; fi
    done
  done
done
echo "Casos correctos: $ok  Fallidos: $fail"
