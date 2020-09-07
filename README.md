# HiltPractice
android Hilt 연습 프로젝트

## build.gradle
```
    classpath 'com.google.dagger:hilt-android-gradle-plugin:2.28-alpha'

    apply plugin: 'kotlin-kapt'
    apply plugin: 'dagger.hilt.android.plugin'

    def hilt_version = '2.28.1-alpha'
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-android-compiler:$hilt_version"

    //jetpack ViewModel
    implementation "androidx.hilt:hilt-common:1.0.0-alpha02"
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
    kapt "androidx.hilt:hilt-compiler:1.0.0-alpha02"
```


## Application
```
@HiltAndroidApp
class App : Application() { ... }
```



## @AndroidEntryPoint
  - activity나 fragment에서 멤버 주입하는 것을 가능케 함
  - 사용할 수 있는 타입 : activity, fragment, view, service, broadcastreceiver 
  
## @InstallIn
  - Hilt 컴포넌트에 모듈을 설치
  - 만약 모듈이 @InstallIn 어노테이션을 가지고 있지 않다면 해당 모듈은 컴포넌트에 설치되지 않아 컴파일 에러를 발생 시킨다.
  - 어떤 컴포넌트가 모듈이 설치될 적당한 Hilt 컴포넌트인지 명시해야한다.
  ```
  Hilt 구성요소	                        인젝터 대상                  생성 위치                   제거 위치
  ApplicationComponent	                Application                 Application#onCreate()      Application#onDestroy()
  ActivityRetainedComponent	            ViewModel                   Activity#onCreate()         Activity#onDestroy()
  ActivityComponent                 	Activity                    Activity#onCreate()         Activity#onDestroy()
  FragmentComponent                 	Fragment                    Fragment#onAttach()         Fragment#onDestroy()
  ViewComponent	                        View                        View#super()
  ViewWithFragmentComponent         	@WithFragmentBindings       View#super()
                                        주석이 지정된 View
  ServiceComponent                  	Service                     Service#onCreate()          Service#onDestroy()
```

```구성요소 범위
Android 클래스	    생성된 구성요소                        	범위
Application	                ApplicationComponent	        @Singleton
View Model	                ActivityRetainedComponent	    @ActivityRetainedScope
Activity	                ActivityComponent	            @ActivityScoped
Fragment	                FragmentComponent	            @FragmentScoped
View	                    ViewComponent	                @ViewScoped
@WithFragmentBindings 
주석이 지정된 View	        ViewWithFragmentComponent   	@ViewScoped
Service	                    ServiceComponent	            @ServiceScoped

```

## viewModel 객체 삽입
```ViewModel 객체의 생성자에서 @ViewModelInject 주석을 사용하여 ViewModel을 제공합니다. 또한 다음과 같이 SavedStateHandle 종속 항목에 @Assisted로 주석을 지정해야 합니다.
class ExampleViewModel @ViewModelInject constructor(
  private val repository: ExampleRepository,
  @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
  ...
}
```
## activity, fragment 에서 viewModel 가져오기
```
@AndroidEntryPoint
class ExampleActivity : AppCompatActivity() {
  private val exampleViewModel: ExampleViewModel by viewModels()
  ...
}

  private val exampleViewModel: ExampleViewModel by activityViewModels()
```











# 참고자료
  - https://developer.android.com/training/dependency-injection/hilt-android?hl=ko
  - 
  
