f,i="final","LLRLRRLLRLRRLLRLRRLRRRLRLRLRRRLLRLRRRLRLRRRLRLRLLLRRLRLRLLRLRRLRRRLRRRLLRRLRLRRRLRRLRRRLRLLRRLRRRLRRRLRRLRLRRLLLRLRLLRRRLRRLLRLRLRRLLRLRRLLRLRRLRRLLRRRLRLRLRRRLLRRRLRRLRRRLRRRLRLRRRLRRLLLRRRLRLLLRRRLRLLRLLRRRLLRRLRRRLRRRLRLLRLRLRRRLLRRLRRRLRRLRLLRRRLRRLRRRLRRRLRRRLRLRRRLRRRLRLRRRR"
def b(c,z,n):return n[c][1] if z == "R" else n[c][0]
def _(s,n):
 c,o,g="AAA",0,0
 while c!="ZZZ":c=b(c,"R" if s[g%len(s)]=="R" else "L",n);o+=1;g+=1;print(c,g%len(s))
 return o
with open(f"{f}.in") as f:k=f.read().splitlines()
n={l[0]:l[1][1:-1].split(", ") for l in (y.split(" = ") for y in k)}
print(_(i,n))