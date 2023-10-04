# STG_LABS
Assignment for WRIKE (STG LABS)

Question: Please find the task that we were discussing on:

Following are three URLs, the goal of this exercise is to return back one of the three responses and the one which returns the fastest result.

            https://api.nationalize.io?name=mike

            https://api.nationalize.io?name=bob

            https://api.nationalize.io?name=sami
Note: The idea is to return the fastest response and not wait on all them to return back and a Unit Test

Sol Approach: We are using JAVA's CompletableFuture and calling the same API with different Params and using the anyOf() method of CompletableFuture which accepts multiple CompletableFutures and return whatever comes first for the same call.
