package com.bcp.sdk.product.peoplecompose.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bcp.sdk.product.peoplecompose.data.repository.PeopleRepositoryImpl
import com.bcp.sdk.product.peoplecompose.domain.usecase.PeopleUseCase
import com.bcp.sdk.product.peoplecompose.presentation.databinding.FragmentPeopleBinding
import com.bcp.sdk.product.peoplecompose.presentation.model.PeoplePresentation
import com.bcp.sdk.product.peoplecompose.presentation.state.PeopleViewState
import com.bcp.sdk.product.peoplecompose.presentation.ui.adapter.PeopleAdapter
import com.bcp.sdk.product.peoplecompose.presentation.util.getViewModel
import com.bcp.sdk.product.peoplecompose.presentation.viewmodel.PeopleViewModel
import kotlinx.coroutines.launch

class PeopleFragment : Fragment() {

    private val binding: FragmentPeopleBinding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    private val peopleAdapter = PeopleAdapter(onClickListener = { people ->
        val action = PeopleFragmentDirections.actionPeopleFragmentToPeopleOneFragment(
            people.id
        )
        findNavController().navigate(action)

    })

    private val peopleViewModel: PeopleViewModel by lazy {
        getViewModel {
            PeopleViewModel(
                peopleUseCase = PeopleUseCase(
                    peopleRepository = PeopleRepositoryImpl()
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setUpObserverPeople()
        getPeople()
    }

    private fun setupRecyclerView() {
        binding.iContentPeople.rvPeople.adapter = peopleAdapter
    }

    private fun setUpObserverPeople() {
        lifecycleScope.launch {
            peopleViewModel.people.collect { people ->
                when (people) {
                    is PeopleViewState.ShowShimmer -> showShimmer()

                    is PeopleViewState.HideShimmer -> hideShimmer()

                    is PeopleViewState.FetchPeople -> loadPeople(people.peopleList)
                    else -> Unit
                }
            }
        }
    }

    private fun showShimmer() {
        with(binding) {
            iShimmerPeopleList.sflPeople.startShimmer()
            iShimmerPeopleList.nsvPeople.visibility = VISIBLE
            iContentPeople.rvPeople.visibility = GONE
        }
    }

    private fun hideShimmer() {
        with(binding) {
            iShimmerPeopleList.sflPeople.stopShimmer()
            iShimmerPeopleList.nsvPeople.visibility = GONE
            iContentPeople.rvPeople.visibility = VISIBLE
        }
    }

    private fun getPeople() = peopleViewModel.fetchPeople()

    private fun loadPeople(list: List<PeoplePresentation>) {
        peopleAdapter.setData(list.toMutableList())
    }
}