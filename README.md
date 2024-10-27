<div align="center">
	<h1>Java sublist memory leak example</h1>
</div>

##  Objective

This project show how it is possible to have memory leak problems using sublist method from java.util.List.

## Executando o projeto

➡️ **Project clone**
```bash
git clone https://github.com/Lubrum/java-sublist-memory-leak.git
```

➡️ **Go to the new folder**
```bash
cd java-sublist-memory-leak
```

➡️ **Run commands below**
```bash
javac src/ObjectSizeFetcher.java
jar cmf MANIFEST.MF object-size-fetcher.jar src/ObjectSizeFetcher.class
```

➡️ **Add following arguments before run or run 'start' on IntelliJ**
```bash
-Xms200m -Xmx200m -javaagent:/home/lu/sys/memory-leak/java-sublist/out/artifacts/java_sublist_jar/java-sublist.jar
```

Explained in portuguese (PT-BR) in this video: https://youtu.be/6zn4k8S-By4