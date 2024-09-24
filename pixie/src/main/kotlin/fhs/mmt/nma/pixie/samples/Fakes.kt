package fhs.mmt.nma.pixie.samples

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import fhs.mmt.nma.pixie.data.Comment
import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.Photography
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.data.User
import fhs.mmt.nma.pixie.samples.FakePhotoSource.Pexels
import fhs.mmt.nma.pixie.samples.FakePhotoSource.RandomDucks
import kotlin.random.Random


private enum class FakePhotoSource {
    Pexels, RandomDucks
}

private data class FakeUser(
    val id: Int,
    val name: String,
    val photoSource: FakePhotoSource,
    val location: String? = null,
    val instagram: String? = null
)

private val FakeUserSource = listOf(
    FakeUser(
        id = 100,
        name = "Magda Reinlangen",
        photoSource = Pexels,
        location = "München"
    ),
    FakeUser(
        id = 200,
        name = "Donald Duck",
        photoSource = RandomDucks,
        location = "Entenhausen",
        instagram = "disney.donaldduck"
    ),
    FakeUser(
        id = 250,
        name = "Alice Wonder",
        photoSource = Pexels,
        instagram = "aliceinwonderlandlc"
    ),
    FakeUser(
        id = 300,
        name = "Wilhelm",
        photoSource = Pexels,
    ),
    FakeUser(
        id = 350,
        name = "Lancelot",
        photoSource = RandomDucks,
        location = "United Kingdom \uD83C\uDDEC\uD83C\uDDE7"
    )
)


val FakeUsers = FakeUserSource.map(::generateFakeUser)

val FakePosts = List(100) {
    generateFakePost()
}

private fun generateFakePost(
    photos: Int = Random.nextInt(from = 1, until = 15),
    likes: Int = Random.nextInt(from = 0, until = 999_999),
    comments: Int = Random.nextInt(0, 1_000)
) = with(FakeUsers.random()) {
    Post(
        author = this,
        photos = List(photos) {
            when (FakeUserSource.find { it.id == id }?.photoSource ?: Pexels) {
                Pexels -> generatePexelsPhoto()
                RandomDucks -> generateDuckPhoto()
            }
        },
        likes = likes,
        comments = generateComments(comments)
    )
}


private fun generateFakeUser(fakeUser: FakeUser) =
    Photographer(
        id = fakeUser.id,
        name = fakeUser.name,
        picture = when (fakeUser.photoSource) {
            Pexels -> generatePexelsPhoto().url
            RandomDucks -> generateDuckPhoto().url
        },
        location = fakeUser.location,
        instagram = fakeUser.instagram,
        bio = LoremIpsum(Random.nextInt(0, 100)).values.joinToString()
    )

private fun generateComment(maxWords: Int = 20, author: User = FakeUsers.random()) = Comment(
    message = LoremIpsum(Random.nextInt(1, maxWords)).values.joinToString(),
    author = author
)

internal fun generateComments(amount: Int = Random.nextInt(0, 20)) = List(amount) {
    generateComment()
}

private fun generatePhoto(url: String) = Photography(
    url = url
)

internal fun generatePexelsPhoto(id: Int = Random.nextInt(from = 6_000_000, until = 8_999_999)) =
    generatePhoto(
        url = "https://images.pexels.com/photos/$id/pexels-photo-$id.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=1080"
    )

private fun generateDuckPhoto(id: Int = Random.nextInt(from = 1, until = 192)) = generatePhoto(
    url = "https://random-d.uk/api/v2/$id.jpg"
)
