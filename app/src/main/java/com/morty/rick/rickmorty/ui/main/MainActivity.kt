package com.morty.rick.rickmorty.ui.main

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.credentials.Credential
import com.google.android.gms.auth.api.credentials.HintRequest
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.morty.rick.rickmorty.MySMSBroadcastReceiver
import com.morty.rick.rickmorty.R
import com.morty.rick.rickmorty.ui.base.BaseActivity
import com.morty.rick.rickmorty.ui.main.fragments.characters.CharactersFragment
import com.morty.rick.rickmorty.ui.main.fragments.episodes.EpisodesFragment
import com.morty.rick.rickmorty.ui.main.fragments.locations.LocationsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, MySMSBroadcastReceiver.Listener {

    private var smsBroadcastReceiver: MySMSBroadcastReceiver? = null
    private var retriever: Task<Void>? = null
    private var mCredentialsApiClient: GoogleApiClient? = null
    private val RESOLVE_HINT = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)

        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.characters -> openCharactersFragment()
                R.id.locations -> openLocationsFragment()
                R.id.episodes -> openEpisodesFragment()
                else -> openCharactersFragment()
            }
        }

        openCharactersFragment()

//        mCredentialsApiClient = GoogleApiClient.Builder(this)
//                .addConnectionCallbacks(this)
//                .enableAutoManage(this, this)
//                .addApi(Auth.CREDENTIALS_API)
//                .build()
//
//        requestHint()
//
//        smsBroadcastReceiver = MySMSBroadcastReceiver()
//        smsBroadcastReceiver?.injectListener(this)
//        startSMSRetriever()
//
//        var appSignatureHelper = AppSignatureHelper(this)
//        Log.e("Hash", appSignatureHelper.getAppSignatures().toString())
    }

    private fun startSMSRetriever() {
        val client = SmsRetriever.getClient(this)
        retriever = client.startSmsRetriever()
        retriever?.addOnSuccessListener {

            Log.e("Receiver", "successfully started")
            registerReceiver(smsBroadcastReceiver, IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION))
        }

        retriever?.addOnFailureListener {
            //Problem to start listener
            Log.e("Receiver", "failure")
        }
    }

    private fun openEpisodesFragment(): Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var episodesFragment = supportFragmentManager.findFragmentByTag(EPISODES_FRAGMENT)
        if (episodesFragment == null)
            episodesFragment = EpisodesFragment.getInstance()
        fragmentTransaction.replace(R.id.main_container, episodesFragment, EPISODES_FRAGMENT)
                .addToBackStack(null)
        fragmentTransaction.commit()
        return true
    }

    private fun openLocationsFragment(): Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var locationsFragment = supportFragmentManager.findFragmentByTag(LOCATIONS_FRAGMENT)
        if (locationsFragment == null)
            locationsFragment = LocationsFragment.getInstance()
        fragmentTransaction.replace(R.id.main_container, locationsFragment, LOCATIONS_FRAGMENT)
                .addToBackStack(null)
        fragmentTransaction.commit()
        return true
    }

    private fun openCharactersFragment(): Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var charactersFragment = supportFragmentManager.findFragmentByTag(CHARACTERS_FRAGMENT)
        if (charactersFragment == null)
            charactersFragment = CharactersFragment.getInstance()
        fragmentTransaction.replace(R.id.main_container, charactersFragment, CHARACTERS_FRAGMENT)
                .addToBackStack(null)
        fragmentTransaction.commit()
        return true
    }

    companion object {
        const val CHARACTERS_FRAGMENT = "characters_fragment"
        const val LOCATIONS_FRAGMENT = "locations_fragment"
        const val EPISODES_FRAGMENT = "episodes_fragment"
    }

    override fun onBackPressed() {
        if (bottom_navigation.selectedItemId != R.id.characters)
            bottom_navigation.selectedItemId = R.id.characters
        else
            finish()
    }

    override fun onConnected(p0: Bundle?) {
        Log.e("onConnected", "onConnected")
    }

    override fun onConnectionSuspended(p0: Int) {
        Log.e("onConnectionSuspended", "onConnectionSuspended")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.e("onConnectionFailed", "onConnectionFailed")
    }

    // Construct a request for phone numbers and show the picker
    private fun requestHint() {
        val hintRequest = HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build()

        val intent = Auth.CredentialsApi.getHintPickerIntent(
                mCredentialsApiClient, hintRequest)
        startIntentSenderForResult(intent.intentSender,
                RESOLVE_HINT, null, 0, 0, 0)
    }

    // Obtain the phone number from the result
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESOLVE_HINT) {
            if (resultCode == Activity.RESULT_OK) {
                val credential = data?.getParcelableExtra(Credential.EXTRA_KEY) as Credential
                Toast.makeText(this@MainActivity, credential.id, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(smsBroadcastReceiver)
    }

    override fun onSMSReceived(otp: String?) {
        Toast.makeText(this@MainActivity, "$otp Main Activity", Toast.LENGTH_SHORT).show()
        unregisterReceiver(smsBroadcastReceiver)
    }

    override fun onTimeOut() {
        Toast.makeText(this@MainActivity, "Timeout Main Activity", Toast.LENGTH_SHORT).show()
    }
}
