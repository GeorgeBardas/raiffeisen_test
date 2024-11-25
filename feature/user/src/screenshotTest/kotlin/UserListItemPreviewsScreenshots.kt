import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.list.compose.UserListItemPreview
import com.example.list.compose.UserListScreenAppendErrorPreview
import com.example.list.compose.UserListScreenAppendLoadingPreview
import com.example.list.compose.UserListScreenErrorPreview
import com.example.list.compose.UserListScreenInitialLoadingPreview
import com.example.list.compose.UserListScreenNoInternetPreview
import com.example.list.compose.UserListScreenPreview

class UserListItemPreviewsScreenshots {

    @PreviewLightDark
    @Composable
    fun UserListItemPreviews() = UserListItemPreview()

    @PreviewLightDark
    @Composable
    fun UserListScreenPreviews() = UserListScreenPreview()

    @PreviewLightDark
    @Composable
    fun UserListScreenInitialLoadingPreviews() = UserListScreenInitialLoadingPreview()

    @PreviewLightDark
    @Composable
    fun UserListScreenAppendLoadingPreviews() = UserListScreenAppendLoadingPreview()

    @PreviewLightDark
    @Composable
    fun UserListScreenAppendErrorPreviews() = UserListScreenAppendErrorPreview()

    @PreviewLightDark
    @Composable
    fun UserListScreenErrorPreviews() = UserListScreenErrorPreview()

    @PreviewLightDark
    @Composable
    fun UserListScreenNoInternetPreviews() = UserListScreenNoInternetPreview()
}