from subprocess import check_output as cmd

command = "javac -d DB db.java db_model.java"
a = cmd("dir /b *.class")
print(a)