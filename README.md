# Android Network and Internet Monitor [![](https://jitpack.io/v/muth0mi/checki.svg)](https://jitpack.io/#muth0mi/checki)

An Android library to check for active network connections as well as internet connectivity before making HTTP(S) requests.


## Installing

First you need to enable the jitpack repository in your project.

Groovy:
```
maven { url 'https://jitpack.io' }
```
Kotlin-DSL: 
```
maven { url = uri("https://jitpack.io") }
```


To be able to use the library, you will need to add the following dependency in your module gradle file.

Groovy:
```
implementation 'com.github.muth0mi:checki:0.0.1'
```
Kotlin-DSL: 
```
implementation ("com.github.muth0mi:checki:0.0.1")
```

Sync Project, and start using the library instantly on your project.


## Usage

You can use it in both Android Activities and Fragments, as shown using the code snippets below. You can now replace the toasts with a call to make your HTTP Request now!
```kotlin
import io.github.muth0mi.checki.*

// ...

  // Observe Network Connection
  ConnectionChecker(this).observe(this, { connected ->
      // Do your thing with [connected]
  })
  
  // Observe Internet Connection
  InternetChecker(this).observe(this, { online ->
      // Do your thing with [online]
  })
  
  // For Jetpack compose, you can observe as follows
  val connected = ConnectionChecker(this).observeAsState(false).value
  val online = InternetChecker(this).observeAsState(false).value
  
// ...
```


## Contributing and Issues

Please feel free to contribute or open issues, if any and I will be happy to help out!


## Commendations

Special thanks to the following people for the inspiration to create this library:

* **[Juma Allan](https://github.com/jumaallan)** for [AndroidNetworkManager](https://github.com/jumaallan/AndroidNetworkManager.git)
* **[Mitch Tabian](https://github.com/mitchtabian)** for [food2fork.ca Compose App](https://github.com/mitchtabian/food2fork-compose.git)


## License

This project is licensed under the [MIT License](https://github.com/muth0mi/checki/blob/master/LICENSE).
