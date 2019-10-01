# ITStudentsApp
sdk creation
--------------- the below link is the tutorial for creation of bintray without third party library ------
https://stackoverflow.com/questions/38211153/distribute-android-library-in-jcenter-to-use-in-gradle/43951025#43951025

--- if any error in javadocs occur 
--- need to add the below code in root(build.gradle) file
subprojects {
    tasks.withType(Javadoc).all { enabled = false }
}


