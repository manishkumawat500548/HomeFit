package com.example.homefit.presentation.profile

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ModeEdit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.homefit.R
import com.example.homefit.navigation.Routes
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder

@Composable
fun ProfileHeader(navController: NavController, viewModel: ProfileViewModel = hiltViewModel()) {

    val userName by viewModel.userName.collectAsState()
    val imageUri by viewModel.profileImage.collectAsState()
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        uri?.let {
            context.contentResolver.takePersistableUriPermission(
                it,
                Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
            viewModel.saveProfileImage(it.toString())
        }
    }
    AppCard(content = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            if (imageUri != null) {
                AsyncImage(
                    model = imageUri,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(
                            CircleShape
                        )
                        .clickable(onClick = {
                            launcher.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        }),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.user1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(
                            CircleShape
                        )
                        .clickable(onClick = {
                            launcher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        }), contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.width(10.dp))

            Column() {
                Text(userName.toString(), color = Color.White)
                Spacer(Modifier.height(4.dp))
                Text("Fitness Enthusiast", color = Color(0xff9da4c2))
                Spacer(Modifier.height(6.dp))
                Button(
                    onClick = {
                        navController.navigate(
                            Routes.ProfileEdit
                        )
                    },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff0e1628)),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(width = 1.dp, color = Color(0xff12161e))
                ) {
                    Row() {
                        Icon(
                            Icons.Default.ModeEdit,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp), tint = Color(0xff452ea3)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Edit Profile",
                            color = Color(0xff452ea3)
                        )
                    }
                }
            }
        }
    })
}

