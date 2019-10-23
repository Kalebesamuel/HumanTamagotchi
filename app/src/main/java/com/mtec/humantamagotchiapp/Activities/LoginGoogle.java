package com.mtec.humantamagotchiapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.mtec.humantamagotchiapp.R;
import com.squareup.picasso.Picasso;

public class LoginGoogle extends AppCompatActivity {

    //===========Firebase
    static final int GOOGLE_SIGN = 123;
    FirebaseAuth mAuth;
    Button btn_login, btn_logout;
    TextView text;
    ImageView image;
    ProgressBar progressBar;
    GoogleSignInClient mGoogleSingInClient;

//===================================================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_google);

        //=========Firebase
        mAuth = FirebaseAuth.getInstance();
        btn_login = findViewById(R.id.bt_SignIn);
        btn_logout= findViewById(R.id.bt_Logout);
        image = findViewById(R.id.photoUser);
        progressBar = findViewById(R.id.progressBar);
        text = findViewById(R.id.infoLogin);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder().requestIdToken(getString(R.string.default_web_client_id)).
                requestEmail().build();
        mGoogleSingInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        btn_login.setOnClickListener(v -> SignInGoogle());
        btn_logout.setOnClickListener(v -> Logout());//o botão logout vai ser definido posteriormente na tela de configurações

        if(mAuth.getCurrentUser() != null) {
            FirebaseUser user = mAuth.getCurrentUser();
            updateUI(user);
        }
    }

//===================================================================================================================================

    void SignInGoogle(){
        progressBar.setVisibility(View.VISIBLE);
        Intent signIntent = mGoogleSingInClient.getSignInIntent();
        startActivityForResult(signIntent, GOOGLE_SIGN);
    }

//===================================================================================================================================


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GOOGLE_SIGN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                if(account != null){
                    firebaseAuthWithGoogle(account);
                }

            } catch (ApiException e){
                e.printStackTrace();
            }
        }
    }

//===================================================================================================================================

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d("TAG", "firebaseAuthWithGoogle: " + account.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, task -> {
            if(task.isSuccessful()){
                progressBar.setVisibility(View.INVISIBLE);
                Log.d("TAG", "Signin Success");
                FirebaseUser user = mAuth.getCurrentUser();
                Toast.makeText(getApplicationContext(), "Bem Vindo " + user.getDisplayName(), Toast.LENGTH_SHORT);
                callDadosIniciaisScreen();
//                updateUI(user);//não será chamado
            } else {

                progressBar.setVisibility(View.INVISIBLE);
                Log.w("TAG", "Sign Failure", task.getException());

                Toast.makeText(this, "Sign Failed", Toast.LENGTH_SHORT);
                updateUI(null);//não será chamado
            }
        });
    }

//===================================================================================================================================

    private void updateUI(FirebaseUser user) {

        if(user != null){

            String name = user.getDisplayName();
            String email = user.getEmail();
            String photo = String.valueOf(user.getPhotoUrl());//photo vai entrar na page de configurações

            text.append("info: \n");
            text.append(name + "\n");
            text.append(email);

            Picasso.get().load(photo).into(image);
            btn_login.setVisibility(View.INVISIBLE);
            btn_logout.setVisibility(View.VISIBLE);//não será definido aqui

        } else {

            text.setText("");
            Picasso.get().load(R.drawable.user_icon).into(image);
            btn_login.setVisibility(View.VISIBLE);
            btn_logout.setVisibility(View.INVISIBLE);

        }
    }

//===================================================================================================================================

    void Logout(){

        FirebaseAuth.getInstance().signOut();
        mGoogleSingInClient.signOut().addOnCompleteListener(this, task -> updateUI(null));
    }

//===================================================================================================================================

    //Chama tela de dados Iniciais
    public void callDadosIniciaisScreen(){
        Intent intent = new Intent(this, DadosIniciais.class);
        startActivity(intent);
    }
}
