# Numbers-Dictionary

## Description
Numbers dictionary is a Java library, suitable for use in a server-side application, that can take a Java int in the range 0 to 999,999,999 inclusive and returns the equivalent number, as a String, in British English words.

## Supported locales
Currently only enGB

## Usage
```java
  int number = 39003333;
  NumbersDictionary dict = NumbersDictionaryRegister.get(new Locale("en", "GB"));
  System.out.println(dict.print(number));
  --- output:
  thirty nine million and three thousand three hundred and thirty three
```

## Dependencies
Java 1.5 or greater

