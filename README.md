[![Build Status](https://travis-ci.com/DerkVanDenBergh/lingo-words.svg?token=xxQrEZvDMqo1qQjSCuLR&branch=master)](https://travis-ci.com/DerkVanDenBergh/lingo-words)
[![codecov](https://codecov.io/gh/DerkVanDenBergh/lingo-words/branch/master/graph/badge.svg?token=CJVEY1B7TT)](https://codecov.io/gh/DerkVanDenBergh/lingo-words)

### Lingo-words import tool ###
This is a tool that can be used to export a wordset to multiple targets. It can be easily expanded and currently posesses the following functionality:

##### Import #####
* Import from file in csv

##### Export #####
* Export to an api endpoint in json

##### Usage #####

```java -jar Wordset-Export.jar file -f <path/to/file> -t <api> -e <Endpoint> -fi <filter> -rf <requestformat> -l <language>```