# jenkins-gradle-build

## Sample pipeline
```
node('maven') {
    stage('GitClone') {
        git 'https://github.com/ruromero/jenkins-gradle-build.git'
    }
    stage('Build') {
        withEnv(["JAVA_OPTS=$GRADLE_OPTS"]){
            sh "./gradlew build --no-daemon --debug"
        }
    }
}
```

## Sample Jenkins Setup
Jenkins ENV variables are
`CONTAINER_HEAP_PERCENT=0.25`
`OPENSHIFT_JENKINS_JVM_ARCH=x86_64`
`GRADLE_OPTS=-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=3`
`GRADLE_TEST_OPTS=-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=3`

With that having limits to 1Gi
jnlp JVM is 256Mb
```
Running java -XX:+UseParallelGC -XX:MaxPermSize=100m -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:MaxMetaspaceSize=100m -Xms256m -Xmx256m -cp /home/jenkins/remoting.jar hudson.remoting.jnlp.Main -headless -url http://172.30.160.158:80 -tunnel 172.30.139.119:50000 88242deaf2360d99034382822705a99fd7ecb273aa89a680ea25374ea2b689ea maven-4ed3bba3b2e78
```
Gradle JVM is 1/3rd of the total and the Gradle Test JVM is the same as shown in the testHello trace
```
11:36:20.024 [DEBUG] [TestEventLogger] com.redhat.openshift.sd.demos.FooTest > testHello STANDARD_OUT
11:36:20.024 [DEBUG] [TestEventLogger]     Heap Size: 15872Mb | Max Heap: 338560Mb | Free Heap: 8518Mb
```
