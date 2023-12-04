package com.bcp.sdk.product.peoplecompose.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bcp.sdk.product.peoplecompose.presentation.R
import com.bcp.sdk.product.peoplecompose.presentation.databinding.FragmentPeopleByIdBinding
import com.bcp.sdk.product.peoplecompose.presentation.model.PeoplePresentation
import com.bcp.sdk.product.peoplecompose.presentation.state.PeopleByIdViewState
import com.bcp.sdk.product.peoplecompose.presentation.viewmodel.PeopleByIdViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleByIdFragment : Fragment() {

    private val binding: FragmentPeopleByIdBinding by lazy {
        FragmentPeopleByIdBinding.inflate(layoutInflater)
    }
    private var id: Int = 0

    private val peopleByIdViewModel: PeopleByIdViewModel by viewModels()
    private val args: PeopleByIdFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.let {
            id = it.peopleId
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserverPreferencesChannel()
        getPeopleById()
    }


    private fun setUpObserverPreferencesChannel() {
        lifecycleScope.launch {
            peopleByIdViewModel.peopleById.collect { people ->
                when (people) {
                    is PeopleByIdViewState.ShowShimmer -> showShimmer()
                    is PeopleByIdViewState.HideShimmer -> hideShimmer()
                    is PeopleByIdViewState.FetchPeople -> loadPeople(people.peopleById)
                    else -> Unit
                }
            }
        }
    }

    private fun showShimmer() {
        with(binding) {
            iShimmerPeopleById.sflPeople.startShimmer()
            iShimmerPeopleById.sflPeople.visibility = VISIBLE
            iContentPeopleById.clPeopleById.visibility = GONE
        }
    }

    private fun hideShimmer() {
        with(binding) {
            iShimmerPeopleById.sflPeople.stopShimmer()
            iShimmerPeopleById.nsvPeople.visibility = GONE
            iContentPeopleById.clPeopleById.visibility = VISIBLE
        }
    }

    private fun getPeopleById() = peopleByIdViewModel.peopleById(id)

    private fun loadPeople(people: PeoplePresentation) {
        with(binding.iContentPeopleById) {
            Picasso.get()
                .load(people.avatar)
                .fit()
                .transform(RoundedCornersTransformation(100, 0))
                .into(ivPeople)

            tvFullName.text = root.context.getString(
                R.string.people_full_name, people.firstName, people.lastName
            )
            tvEmail.text = people.email
        }
    }
}