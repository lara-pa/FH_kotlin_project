# Goal

The Goal of this Project is to Design a given UI Specification using Jetpack Compose

## General Grading Criteria

- [ ] All code has to be written in Kotlin
    - If you are using external dependencies it is fine if these are written in Java
- [ ] UI is written completely with Jetpack Compose
    - [ ] Single Activity
      using [ComponentActivity](https://developer.android.com/reference/androidx/activity/ComponentActivity)
    - [ ] Navigation is
      using [compose-navigation](https://developer.android.com/jetpack/compose/navigation)
- [ ] Hardcoded Strings are localized using string resources
- [ ] Icons are vectors
  using [material-icons](https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary)
- [ ] UI Follows the [Style Guide](STYLEGUIDE.md)

## Data

The Data Structure for this Project is given. All Domain Models can be found in
the [data](../pixie/src/main/kotlin/fhs/mmt/nma/pixie/data) package.

There are ready to use Fake Data and Sample Data Providers available in
the [samples](../pixie/src/main/kotlin/fhs/mmt/nma/pixie/samples) package

## Grading

All Tasks are worth a total of **82** Points

Scala:

- **70**: 1
- **60**: 2
- **50**: 3
- **40**: 4

### General App Structure - *10P*

- [ ] Theme following the [Style Guide](STYLEGUIDE.md) - *6P*
    - [ ] Typography - *1P*
    - [ ] Light Colors - *2P*
    - [ ] Dark Colors - *2P*
    - [ ] Dark or Light Theme is applied depending on System Settings - *1P*
- [ ] Navigation
  via [compose-navigation](https://developer.android.com/jetpack/compose/navigation) - *4P*
    - [ ] Application uses Navigation component - *1P*
    - [ ] Navigation starts
      with [HomeScreen](../pixie/src/main/kotlin/fhs/mmt/nma/pixie/ui/home/HomeScreen.kt) - *1P*
    - [ ] Navigation can navigate
      to [ProfileScreen](../pixie/src/main/kotlin/fhs/mmt/nma/pixie/ui/profile/ProfileScreen.kt) -
      *2P*
        - [ ] Navigation takes the `userId` as Argument - *1P*

### Home Screen - *40P*

- [ ] Screen Contains
  a [TopAppBar](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.ui.unit.Dp,androidx.compose.foundation.layout.WindowInsets,androidx.compose.material3.TopAppBarColors,androidx.compose.material3.TopAppBarScrollBehavior))
  *1P*
- [ ] Displays a Scrollable List of All Posts - *3P*
    - [ ] List is using [LazyColumn](https://developer.android.com/jetpack/compose/lists) - *1P*
    - [ ] Items have correct Spacing
      using [Arrangement](https://developer.android.com/jetpack/compose/lists#content-spacing) -
      *1P*
    - [ ] List is
      displaying [PostCard](../pixie/src/main/kotlin/fhs/mmt/nma/pixie/ui/home/PostCard.kt) Items -
      *1P*
- [ ] Post Cards are displaying all Information
    - [ ] Author Profile Picture - *2P*
        - [ ] Circular Shape - *1P*
        - [ ] Colored Outline - *1P*
    - [ ] Author Name - *1P*
    - [ ] Clicking the Author Image or Name should navigate to
      the [ProfileScreen](../pixie/src/main/kotlin/fhs/mmt/nma/pixie/ui/profile/ProfileScreen.kt) -
      *1P*
    - [ ] Author Location - *1P*
    - [ ] Post Image - *3P*
        - [ ] Image is loaded using [Coil](https://coil-kt.github.io/coil/compose/) - *1P*
        - [ ] While the image is loading a Placeholder is displayed - *1P*
        - [ ] Images that cannot be loaded display an Error Icon
    - [ ] Posts containing Multiple Images display using
      a [HorizontalPager](https://developer.android.com/jetpack/compose/layouts/pager) - *6P*
        - [ ] All Posts can be accessed by swiping - *2P*
        - [ ] The Current Page is indicated by a Circular Paging Indicator - *2P*
        - [ ] A Badge Indicating the Current and Total Images is displayed - *2P*
    - [ ] Amount of Likes using
      a [TextButton](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TextButton(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.foundation.interaction.MutableInteractionSource,androidx.compose.material.ButtonElevation,androidx.compose.ui.graphics.Shape,androidx.compose.foundation.BorderStroke,androidx.compose.material.ButtonColors,androidx.compose.foundation.layout.PaddingValues,kotlin.Function1)) -
      *5P*
        - [ ] The total amount of likes - *1P*
        - [ ] Posts liked by the user are indicated with the `filled` variant of the `Favorite` Icon
          from [material-icons](https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary) -
          *1P*
        - [ ] Posts _not_ liked by the user are indicated with the `default` variant of the
          `Favorite` Icon
          from [material-icons](https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary) -
          *1P*
        - [ ] Clicking the Button Toggles the users liked state - *2P*
- [ ] Amount of Comments using
  a [TextButton](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TextButton(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Boolean,androidx.compose.foundation.interaction.MutableInteractionSource,androidx.compose.material.ButtonElevation,androidx.compose.ui.graphics.Shape,androidx.compose.foundation.BorderStroke,androidx.compose.material.ButtonColors,androidx.compose.foundation.layout.PaddingValues,kotlin.Function1)) -
  *2P*
    - [ ] The total amount of comments - *1P*
    - [ ] Button is not clickable and has no indication - *1P*
- [ ] The 2 _newest_ Comments - *4P*
    - If no comments are present, no space is taken - *1P*
    - If there are more than 2 Comments a button "Show all Comments" is shown - *1P*
        - The button should be clickable but needs no action
    - Post Author is clickable and opens
      the [ProfileScreen](../pixie/src/main/kotlin/fhs/mmt/nma/pixie/ui/profile/ProfileScreen.kt) -
      *1P*
    - Comments are displaying maximum 2 Lines. The overflow should Ellipsize - *1P*
- [ ] Screen is using MVVM Architecture and has a `HomeViewModel` - *10P*
    - [ ] Screen State is represented using
      a [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow#stateflow) -
      *3P*
        - [ ] There is a Loading and Content State
    - [ ] State is Collected honoring the lifecycle - *2P*
    - [ ] Composables take advantage
      of [State Hoisting](https://developer.android.com/jetpack/compose/state#state-hoisting) - *4P*
        - [ ] Previews for all States are Present - *1P*

### Home Screen - *32P*

- [ ] Screen Contains
  a [TopAppBar](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.ui.unit.Dp,androidx.compose.foundation.layout.WindowInsets,androidx.compose.material3.TopAppBarColors,androidx.compose.material3.TopAppBarScrollBehavior)) -
  *3P*
    - [ ] The Current User Name is Displayed - *1P*
    - [ ] Contains a Back Button - *2P*
        - [ ] Clicking the Button should navigate backwards
- [ ] The Whole Screen Content is Scrollable
  using [LazyVerticalGrid](https://developer.android.com/jetpack/compose/lists) - *3P*
    - [ ] The TopAppBar should remain Stationary - *1P*
    - [ ] Author Profile Picture - *2P*
        - [ ] Circular Shape - *1P*
        - [ ] Colored Outline - *1P*
    - [ ] Total Amount of likes across all Posts - *2P*
        - Large Numbers are formatted in a human readable format
          using [NumberFormatter](https://developer.android.com/reference/android/icu/number/NumberFormatter) -
          *1P*
    - [ ] Total Amount of Photos - *2P*
        - Large Numbers are formatted in a human readable format
          using [NumberFormatter](https://developer.android.com/reference/android/icu/number/NumberFormatter) -
          *1P*
    - [ ] Total Amount of Comments the User has Posted - *2P*
        - Large Numbers are formatted in a human readable format
          using [NumberFormatter](https://developer.android.com/reference/android/icu/number/NumberFormatter) -
          *1P*
    - [ ] Location with an Leading Icon - *1P*
    - [ ] If present Social Media Account with leading Icon - *1P*
    - [ ] Profile Description (Bio) - *1P*
    - [ ] All Photos Posted by the User - *5P*
        - [ ] Image - *3P*
            - [ ] Image is loaded using [Coil](https://coil-kt.github.io/coil/compose/) - *1P*
            - [ ] While the image is loading a Placeholder is displayed - *1P*
            - [ ] Images that cannot be loaded display an Error Icon
        - [ ] The Amount of Images displayed within one Row is Dynamic depending on Available Screen
          Size. Items should have a `minSize` of `128.dp` - *2P*
- [ ] Screen is using MVVM Architecture and has a `ProfileViewModel` - *12P*
    - [ ] The `userId` argument from Navigation is extracted within the ViewModel - *2P*
        - [ ] If the Argument cannot be read or is missing the State should go into the Error State.
    - [ ] Screen State is represented using
      a [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow#stateflow) -
      *3P*
        - [ ] There is a Loading, Content and Error State
    - [ ] State is Collected honoring the lifecycle - *2P*
    - [ ] Composables take advantage
      of [State Hoisting](https://developer.android.com/jetpack/compose/state#state-hoisting) - *4P*
        - [ ] Previews for all States are Present - *1P*

### Bonus: Comments Screen - *27P*

This is an Optional Task and _not_ required for passing. This however gives you a chance of scoring
extra Points.

- [ ] data structure is adjusted to allow Identification of Posts - *2P*
    - [ ] Sample/Fake Data generation is adjusted
- [ ] Screen can be navigated to using Navigation - *5P*
    - [ ] The route contains the `postId` as argument - *2P*
    - [ ] Destination is a [Full-screen](https://m3.material.io/components/dialogs/specs) `dialog`
      destination - *3P*
- [ ] Screen contains a "Close" Action - *2P*
- [ ] Screen is Scrollable using [LazyColumn](https://developer.android.com/jetpack/compose/lists) -
  *2P*
- [ ] All Comments for the given Post are Displayed - *2P*
    - [ ] Comments are displayed in full content, no truncation
- [ ] Post Author is Displayed, Clicking on the Author should navigate to the ProfileScreen - *2P*
- [ ] Screen is using MVVM Architecture and has a `PostCommentViewModel` - *12P*
    - [ ] The `postId` argument from Navigation is extracted within the ViewModel - *2P*
        - [ ] If the Argument cannot be read or is missing the State should go into the Error State.
    - [ ] Screen State is represented using
      a [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow#stateflow) -
      *3P*
        - [ ] There is a Loading, Content and Error State
    - [ ] State is Collected honoring the lifecycle - *2P*
    - [ ] Composables take advantage
      of [State Hoisting](https://developer.android.com/jetpack/compose/state#state-hoisting) - *4P*
        - [ ] Previews for all States are Present - *1P*