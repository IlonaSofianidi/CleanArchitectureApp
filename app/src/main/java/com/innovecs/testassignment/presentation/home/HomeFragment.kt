package com.innovecs.testassignment.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.innovecs.testassignment.R
import com.innovecs.testassignment.core.NotificationType
import com.innovecs.testassignment.core.Notifications
import com.innovecs.testassignment.databinding.FragmentFirstBinding
import com.innovecs.testassignment.presentation.home.model.ActionType
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButton()
        subscribeToButtonAction()
    }

    private fun setupButton() {
        binding.buttonAction.setOnClickListener {
            viewModel.retrieveAction()
        }
    }

    private fun subscribeToButtonAction() {
        viewModel.action.observe(viewLifecycleOwner) { actionUI ->
            Log.d(TAG, "subscribeToButtonAction: action retrieved $actionUI")
            when (actionUI?.actionType) {
                ActionType.TOAST -> showToast()
                ActionType.NOTIFICATION -> displayNotification()
                ActionType.CALL -> callContacts()
                ActionType.ANIMATION -> showAnimation()
                ActionType.NONE -> Log.d(TAG, "subscribeToButtonAction: action none")
                else -> {
                    Log.d(TAG, "subscribeToButtonAction: action not defined")
                }
            }
        }
    }

    private fun showToast() {
        //TODO Add network check
        //TODO Move to string resources
        Toast.makeText(context, "Action is TOAST", Toast.LENGTH_LONG).show()
    }

    private fun displayNotification() {
        context?.let {
            Notifications.showNotification(
                context = it,
                contentTitle = getString(R.string.notification_title),
                contentText = getString(R.string.notification_title),
                notificationId = R.id.notification_button_id,
                type = NotificationType.NOTIFICATION_LOW
            )
        }
    }

    private fun callContacts() {
        TODO("Not yet implemented")
    }

    private fun showAnimation() {
        binding.buttonAction.apply {
            rotation = 0f
            animate().rotation(ANIMATION_ANGLE)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private companion object {
        private const val TAG = "HomeFragment"
        private const val ANIMATION_ANGLE = 360f
    }
}